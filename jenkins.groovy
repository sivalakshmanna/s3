pipeline {
    agent any

    stages {
        stage('git clone') {
            steps {
                git branch: 'main', url: 'https://github.com/sivalakshmanna/ec2.git'
            }
        }
        stage('terraform init') {
            steps {
                sh "terraform init "
            }
        
        }
        stage('terraform format') {
            steps {
                sh "terraform fmt"
            }
        
        }
        stage('terraform validate') {
            steps {
                sh "terraform validate"
            }
        
        }
        stage('terraform plan') {
            steps {
                sh "terraform plan"
            }
        
        }
        stage('terraform apply') {
            steps {
                echo " terraform ${action}"
                sh "terraform ${action} --auto-approve"
            }
        
        }
        stage('email') {
            steps {
                sh "pwd"
               emailext attachLog: true, body: 'image build is complite', compressLog: true, replyTo: 'kuruva.devops02@gmail.com', subject: 'build is success', to: 'kuruva.devops02@gmail.com'
            }
        }
    }
    
        
}
