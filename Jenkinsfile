pipeline {

    agent any
    tools {
        maven 'Maven' 
    }
    stages {
        stage('Compile stage') {
            steps {
                bat "mvn clean compile" 
        }
    }
	stage("build & SonarQube analysis-----") {
            steps {
              withSonarQubeEnv('Sonar') {
                bat 'mvn clean package sonar:sonar'
              }
            }
			}

         stage('testing stage') {
             steps {
                bat "mvn test"
                junit allowEmptyResults: true, testResults:'**/target/*.xml' 
        }
    }

          stage('Install stage') {
              steps {
                bat "mvn install"
                archiveArtifacts artifacts: '**/target/*.war', fingerprint: true 
        }
    }
	
stage('publish'){
	steps{
        nexusArtifactUploader artifacts: [[artifactId: 'Temporary', classifier: '', file: '/var/lib/jenkins/workspace/PizzaBotPipeline/target/Temporary-0.0.1-SNAPSHOT.war', type: 'war']], credentialsId: 'admin', groupId: 'com.cg', nexusUrl: '192.168.1.5:8081/', nexusVersion: 'nexus3', protocol: 'http', repository: 'Pipeline', version: '0.0.1'
	}
       
      }

  }
 
}