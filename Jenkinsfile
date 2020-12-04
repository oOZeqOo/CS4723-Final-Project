pipeline {

    agent any

    stages {
        stage ('Build Stage'){
            steps{
                withMaven(maven : 'maven_3_6_2'){
                    echo ' mvn -B -DskipTests clean package'
                }
            }
        }


        stage ('Testing Stage'){
           steps{
               withMaven(maven : 'maven_3_6_2'){
                   echo 'mvn test'
               }
           }
        }

        stage ('Deployment Stage'){
           steps{
               withMaven(maven : 'maven_3_6_2'){
                   echo 'mvn deploy'
                   echo '''ybu288'''
               }
           }
        }

    }


}
