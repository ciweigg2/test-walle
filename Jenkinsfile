pipeline {
  agent any
  stages {
    stage('package') {
      steps {
        sh 'mvn clean install package \'-Dmaven.test.skip=true\''
      }
    }

  }
}