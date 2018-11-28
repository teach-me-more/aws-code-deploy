   def  configLatest = readProperties file:'pipeline/config.properties'
   
     def  config = readProperties file:'pipeline/config.properties'

                    echo "Reading property --- ${config['application.name']}"
