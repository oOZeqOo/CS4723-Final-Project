pipeline {

    agent any

    stages {
        stage ('Build Stage'){
            steps{
                withMaven(maven : 'maven_3_6_2'){
                    bash ' mvn -B -DskipTests clean package'
                }
            }
        }


        stage ('Testing Stage'){
           steps{
               withMaven(maven : 'maven_3_6_2'){
                   bash 'mvn test'
                   bash '''The goal of these Tests are to see if the Bcc and Cc are working as intended'''
               }
           }
        }

        stage ('Deployment Stage'){
           steps{
               withMaven(maven : 'maven_3_6_2'){
                   bash './deliver.bash'
               }
           }
        }

    }


}
