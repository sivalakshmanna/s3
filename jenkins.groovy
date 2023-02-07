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
                sh "terraform init -reconfigure"
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
    }
    
        
}
