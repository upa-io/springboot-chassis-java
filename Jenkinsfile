pipeline {

    agent any

    stages {
        stage('Git Checkout') {
            steps {
                git branch: 'main', url: 'https://github.com/upa-io/microservice-poc.git'
            }
        }
        stage('Unit Testing') {
            steps {
                sh 'mvn test'
            }
        }
        stage('Integration Testing') {
            steps {
                sh 'mvn verify -DskipUnitTests'
            }
        }
        stage('Maven Build') {
            steps {
                sh 'mvn clean install'
            }
        }
        stage ('SonarCloud Analysis') {
            steps {
                script {
                    withSonarQubeEnv(credentialsId: '7992b875-d441-482d-9de4-2237ae5d2ad9') {
                        sh 'mvn clean package sonar:sonar'
                    }
                }
            }
        }
    }
}