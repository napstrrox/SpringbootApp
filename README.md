# SpringbootApp

This Application main aim to learn springboot with Rest Webswebrvices expose three Rest Api.
Below the details.


1. Fibonacci  
GET /api/Fibonacci  
Returns the nth Fibonacci number.  
Implementation Notes Returns the nth number in the Fibonacci sequence

Request URL 
https://localhost:7070/api/Fibonacci?n=10


2. ReverseWords  
GET /api/ReverseWords  
Reverses the letters of each word in a sentence.  
Implementation Notes Reverses the letters of each word in a sentence

Request URL 
https://localhost:7070/api/ReverseWords?sentence=how%20are%20you



3. TriangleType  
GET /api/TriangleType  
Returns the type of triangle given the lengths of its sides.  
Implementation Notes Returns the type of triangle given the lengths of its sides 

Request URL 
https://localhost:7070/api/TriangleType?a=1&b=1&c=1 


4. Make one array 
 
POST /api/makeonearray 
Accepts JSON objects with multiple number arrays. Combine these arrays, removes duplicate numbers and sorts them. 
Response is JSON object which contains this combined sorted array. 

Request URL 
http://localhost:7070/api/makeonearray
{
"array1":[1,2,3,4], 
"array2":[3,4,5,6], 
"array3":[6,1,3,11]
}


