package core;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/*
 The main goal is to provide an introduction to testing the basic correctness of  the API – and
 we’re using the latest version of the GitHub REST API for the examples.
For an internal application, this kind of testing will usually run as a late step in a 
Continuous Integration process, consuming the REST API after it has already been deployed.
When testing a REST resource, there are usually a few orthogonal responsibilities the tests 
should focus on:

the HTTP response code
other HTTP headers in the response
the payload (JSON, XML)
Each test should only focus on a single responsibility and include a single assertion. 
Focusing on a clear separation always has benefits, but when doing this kind of black box testing 
it’s even more important, as the general tendency is to write complex test scenarios in the very beginning.
Another important aspect of the integration tests is adherence to the Single Level of Abstraction Principle – 
the logic within a test should be written at a high level. Details such as creating the request, 
sending the HTTP request to the server, dealing with IO, etc should not be done inline but via utility methods.
 */
 @RunWith(Suite.class)

 @SuiteClasses
 ({HTTP_response.class,
   Over_Headers_HTTP_response.class,
   JSON_Payload.class})

public class All_TestCases {

	}


