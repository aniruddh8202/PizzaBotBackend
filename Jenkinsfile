pipeline {

    agent any
    tools {
        maven 'Maven' 
    }
    environment {
    	NEXUS_VERSION = "nexus3"
    	NEXUS_PROTOCOL = "http"
    	NEXUS_URL = "localhost:8081"
    	NEXUS_REPOSITORY = "Pipeline"
    	NEXUS_CREDENTIAL_ID = "1cdb8165-4cef-40e3-9883-758c30c0b791"
    }
    stages {
        stage('Compile stage') {
            steps {
                bat "mvn clean compile" 
        }
    }
	// stage("build & SonarQube analysis-----") {
 //            steps {
 //              withSonarQubeEnv('Sonar') {
 //                bat 'mvn clean package sonar:sonar'
 //              }
 //            }
	// 		}

 //         stage('testing stage') {
 //             steps {
 //                bat "mvn test"
 //                junit allowEmptyResults: true, testResults:'**/target/*.xml' 
 //        }
 //    }

          stage('Install stage') {
              steps {
                bat "mvn install"
                archiveArtifacts artifacts: '**/target/*.war', fingerprint: true 
        }
    }
	
// stage('publish'){
// 	steps{
//         nexusArtifactUploader artifacts: [[artifactId: 'Temporary', classifier: '', file: 'target/Temporary-0.0.1-SNAPSHOT.war', type: 'war']], credentialsId: '1cdb8165-4cef-40e3-9883-758c30c0b791', groupId: 'com.example', nexusUrl: 'localhost:8081/', nexusVersion: 'nexus3', protocol: 'http', repository: 'Pipeline', version: '0.0.1-SNAPSHOT'
// 	}
       
//       }

stage("publish to nexus") {
            steps {
                script {
                    // Read POM xml file using 'readMavenPom' step , this step 'readMavenPom' is included in: https://plugins.jenkins.io/pipeline-utility-steps
                    pom = readMavenPom file: "pom.xml";
                    // Find built artifact under target folder
                    filesByGlob = findFiles(glob: "target/*.${pom.packaging}");
                    // Print some info from the artifact found
                    echo "${filesByGlob[0].name} ${filesByGlob[0].path} ${filesByGlob[0].directory} ${filesByGlob[0].length} ${filesByGlob[0].lastModified}"
                    // Extract the path from the File found
                    artifactPath = filesByGlob[0].path;
                    // Assign to a boolean response verifying If the artifact name exists
                    artifactExists = fileExists artifactPath;
                    if(artifactExists) {
                        echo "*** File: ${artifactPath}, group: ${pom.groupId}, packaging: ${pom.packaging}, version ${pom.version}";
                        nexusArtifactUploader(
                            nexusVersion: NEXUS_VERSION,
                            protocol: NEXUS_PROTOCOL,
                            nexusUrl: NEXUS_URL,
                            groupId: pom.groupId,
                            version: '${BUILD_NUMBER}',
                            repository: NEXUS_REPOSITORY,
                            credentialsId: NEXUS_CREDENTIAL_ID,
                            artifacts: [
                                // Artifact generated such as .jar, .ear and .war files.
                                [artifactId: pom.artifactId,
                                classifier: '',
                                file: artifactPath,
                                type: pom.packaging],
                                // Lets upload the pom.xml file for additional information for Transitive dependencies
                                [artifactId: pom.artifactId,
                                classifier: '',
                                file: "pom.xml",
                                type: "pom"]
                            ]
                        );
                    } else {
                        error "*** File: ${artifactPath}, could not be found";
                    }
                }
            }
        }

stage('deploy'){
	steps{
		bat "curl -v -u admin:admin -T C:/Users/Aniruddh/.jenkins/workspace/PizzaBotPipeline/target/Temporary-0.0.1-SNAPSHOT.war 'localhost:1234//manager/text/deploy?path=/PipelinePizzaBot'"
	}
}



  }




 
}