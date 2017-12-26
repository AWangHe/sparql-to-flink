/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.univalle.rdf;

import org.univalle.rdf.mapper.CreateJavaFlinkProgram;
import org.univalle.rdf.mapper.LoadQueryFile;
import org.univalle.rdf.mapper.TransformLQPToFP;
import org.univalle.rdf.mapper.TranslationQueryToLQP;

import java.nio.file.Path;
import java.nio.file.Paths;

public class SparqlQueryToFlinkProgram {

	public static void main(String[] args) throws Exception {
	    Path queryFile=null, datasetFile=null;

        if (args != null && args.length == 2) {
            queryFile = Paths.get(args[0]);
            datasetFile = Paths.get(args[1]);

            String name = queryFile.getFileName().toString();
            name = name.substring(0, name.indexOf('.'));
            name = name.toLowerCase();
            name = name.substring(0, 1).toUpperCase() + name.substring(1, name.length());

            LoadQueryFile query = new LoadQueryFile(queryFile.toString());
            System.out.println();
            System.out.println("----------- Declarative SPARQL Query ---------------");
            System.out.println(query.loadQueryFile());

            TranslationQueryToLQP lqp = new TranslationQueryToLQP(query.loadQueryFile());
            System.out.println("----------- Logical Query Plan ---------------");
            System.out.println(lqp.translationQueryToLQP());
            System.out.println();

            TransformLQPToFP fp = new TransformLQPToFP(lqp.translationQueryToLQP(), datasetFile.toString(), name);
            System.out.println("----------- Java Flink Program ---------------");
            System.out.print(fp.lQPToFlinkProgram());

            CreateJavaFlinkProgram jfp = new CreateJavaFlinkProgram(fp.lQPToFlinkProgram(), name);
            jfp.createJavaFP();

        } else {
			System.out.println("\nYou have to specify two arguments: query_file and dataset_file separated by space \n" +
                    "For example: java -jar flink-java-rdf.jar path_query_file/query_file.rq path_dataset_fiel/dataset_file");
		}
	}
}
