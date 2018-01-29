#!/usr/bin/env bash

export RUNCRUD_HOME=/Users/mikepolak/Downloads/michal-kalas-project-master

startSafari()
{
    open -a /Applications/Safari.app http://localhost:8080/crud/v1/task/getTasks

}

ok()
{
echo "Ok"
}

fail()
{
echo "Error"
}

if ./gradlew build; then
   chmod +x runcrud.sh
   startSafari
   ok
else
  fail
fi

