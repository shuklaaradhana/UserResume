# UserResume Application<br/>

#### Key points - <br/>
1. Used Dagger 2 for injection of Activities, Fragments and other classes <br/>
2. Used Retrofit 2 for network calls <br/>
3. Used RxJava 2 <br/>
4. Used Data Binding to set the text and onClick calls <br/>
5. Used JUnit and Mockito for Unit testing <br/>
6. Used Kotlin <br/>
7. Using MVVM design pattern <br/>
8. Used dimen and style xml files to standardize the layout throughout the app <br/>
9. Used vector drawables <br/>
10. Used RecylerView to show - <br/>
* User names list on the first screen <br/>
* List of the user experiences when clicking on a particular user name on the first screen, user is navigated to his resume  <br/> <br/>

##### The app consists of two screens - <br/>
* First screen shows the list of users, uses RecylerView (ResumeListFragment) <br/>
* When you click on the user name on the first screen, resume details of that user are shown along with the list of his experiences. The list of experiences is a recycler view which can be scrolled. (ResumeDetailsFragment)

![User_Resumes_List](https://user-images.githubusercontent.com/5384429/66353630-53be2280-e917-11e9-8122-3588f5932dd9.png)
![User_Resume_Details](https://user-images.githubusercontent.com/5384429/66353634-591b6d00-e917-11e9-89c0-f129424ab9be.png)
