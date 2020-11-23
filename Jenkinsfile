pipeline {
    agent any

    stages {
              
        stage('Build') {
            steps {
                sh './gradlew assemble'
            }
        }
        
        stage ('Source Composition Analysis') {
            steps {
              dependencyCheck additionalArguments: '--format HTML --format XML', odcInstallation: 'Owasp'
              dependencyCheckPublisher pattern: '**/dependency-check-report.xml'
           }
        }
        
        
        stage('Test') {
            steps {
                sh './gradlew test'
            }
        }
        
        stage('SonarQube analysis') {
             steps {
                withSonarQubeEnv('sonar') {
                 sh './gradlew sonarqube'
                }
             }
        }  
        
    }
}
