# sparql-to-flink
An approach for transforming a given SPARQL query into an Apache Flink program for querying massive static RDF data

# Transform your SPARQL query to Apache Flink program

Run the Sparql2FLink java application with the name of the query file and the name of the input dataset

```
java Sparql2FLink examples/query.rq examples/dataset.ttl
```

# Create the .jar to be runned on you Flink cluster

Deploy with maven

```
mvn -f pom_2.xml clean compile package
```
