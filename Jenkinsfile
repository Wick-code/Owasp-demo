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
              dependencyCheck additionalArguments: '', odcInstallation: 'Owasp'
              dependencyCheckPublisher pattern: ''
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
