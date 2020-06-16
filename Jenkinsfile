pipeline {
  agent {
    docker {
      image 'maven'
      args '''-v /root/.m2:/root/.m2
-v /data/maven/apache-maven-3.6.0/conf/settings.xml:/data/maven/conf/settings.xml
--entrypoint='''
    }

  }
  stages {
    stage('package') {
      steps {
        sh 'mvn clean install package \'-Dmaven.test.skip=true\''
      }
    }

    stage('build') {
      steps {
        sh 'sh package-prod.sh'
      }
    }

  }
}