# Parameterize a pipeline
Parameters are defined in a `parameters` block which is placed at the beginning of the pipeline code.
```
pipeline {
    agent any
    parameters {
       …
    }
    …
}
```

Parameters are accessed by their name preceded by the  `params` prefix.

If they’re used in a string need to have a dollar sign at the beginning and can also be wrapped in curly braces.
```
params.PARAMETER_NAME
“${params.PARAMETER_NAME}”
```

# Declaring parameters
Each parameter definition must include a name, a default value, and a description that explains the type of value that should be entered.

For pipelines, there are five different types of parameters we can use:
- String
- Text
- Boolean
- Choice
- Password

# Sample pipeline with parameters
Use the following pipeline script to experiment with parameters.
```
pipeline {
    agent any
    parameters {
        string(name: 'TRAINER',
               defaultValue: 'Yasir',
               description: 'Enter Your TRAINER’s name')

        text(name: 'TOPIC',
                description: 'Enter your favorite TOPIC from this DevOps Training',
                defaultValue: 'Linux, GIT, Docker, Kubernetes, Jenkins')

        booleanParam(name: 'Is_TRAINING_Interested',
                defaultValue: true,
                description: 'Select True / Unselect False.')

        choice(name: 'CITY',
                choices: ['Karachi', 'Islamabad', 'Lahore'],
                description: 'Select the City.')

        password(name: 'WIFI_PASSWORD',
                defaultValue: 'WIFI_PASSWORD',
                description: 'Enter the WIFI password')
    }
    stages {
        stage('Example') {
            steps {
                echo "I am your TRAINER.  My name is ${params.TRAINER}"
                echo "My favorite TOPIC is ${params.TOPIC}"
                echo "Is this training interested? ${params.Is_TRAINING_Interested}"
                echo "I live in ${params.CITY}"
                echo "WiFi Password? ${params.WIFI_PASSWORD}"
            }
        }
    }
}
```
