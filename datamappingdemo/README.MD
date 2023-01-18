The AtlasMap is a data mapping solution with an interactive web-based user interface, that simplifies configuring integrations between Java, XML, and JSON data sources. You can design your data mapping on the AtlasMap Data Mapper UI canvas, and then run that data mapping via the runtime engine. AtlasMap Data Mapper UI is primarily designed to work within the Syndesis UI, and now we're exploring to improve the standalone user experience.


You can install the standalone version of AtlasMap from Git Hub to run locally and work with your application.
Reference Link: https://github.com/atlasmap/atlasmap  

Once installed you can access the application at http://127.0.0.1:8585 
<img width="1792" alt="Screenshot 2023-01-18 at 4 38 03 PM" src="https://user-images.githubusercontent.com/88180244/213166800-94a2a0b2-09a8-41af-a212-a027f320455c.png">

Once launched you can create your data conversion logic here or import the existing ones as well.

<b>Importing an Existing Data Mapper File<b>
  
  Click on Atlas Map and select Import a catalog option from the list
  <img width="927" alt="Screenshot 2023-01-18 at 4 41 15 PM" src="https://user-images.githubusercontent.com/88180244/213167192-1fd3db9b-636b-4670-8764-9127460bc2a7.png">
  
  Select the path of your .adm file.
  <img width="927" alt="Screenshot 2023-01-18 at 4 41 15 PM" src="https://user-images.githubusercontent.com/88180244/213167328-c05c029c-50fa-4afb-8483-60bf2c01850d.png">
  
  Once imported it will look like the below:
  <img width="1790" alt="Screenshot 2023-01-18 at 4 44 23 PM" src="https://user-images.githubusercontent.com/88180244/213167404-9295f09a-32b7-41bd-be4f-84746bd024f1.png">

<b>Using Data Mapping files inside the application<b>
  
  To use the data mapper file inside your application put it under the src/main/java/resources directory.
  <img width="580" alt="Screenshot 2023-01-18 at 4 57 30 PM" src="https://user-images.githubusercontent.com/88180244/213167637-17e15cde-bfef-442b-8799-09ed28ef5a31.png">
  
  Once you have added the file, You can refere this file inside the route of your application.
  <img width="1703" alt="Screenshot 2023-01-18 at 4 59 09 PM" src="https://user-images.githubusercontent.com/88180244/213167840-43003e53-3ff5-4b5f-b157-d3799f3091c8.png">
  
  The above example does the JSON to XML conversion for the given input data.
  <img width="1245" alt="Screenshot 2023-01-18 at 4 57 52 PM" src="https://user-images.githubusercontent.com/88180244/213167924-e8b6edc7-9bd8-4179-a27c-a05ee5bd2fb4.png">







