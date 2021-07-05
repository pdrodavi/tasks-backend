pipeline {
    
    agent any
    
    stages {
        
        stage('Build Back') {
            steps {
                bat 'mvn clean package -DskipTests=true'
            }
        }
        
    }
    
}
