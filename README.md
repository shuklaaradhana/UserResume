- [Introduction](#introduction)
- [Installation](#installation)
- [Tools and Technologies used](#tools-and-technologies-used)
- [Run the test cases](#run-the-test-cases)

## Introduction
The app is used to view the resume of the user. The data is uploaded on gist.github.com and is being fetched using Retrofit by the app. The data contains the resume of all the users in Json format. The data from the server is converted into the Kotlin data class which is being used to show the resume details on the UI.

## Installation 
#### _I have uploaded pre-released APK to the release tab - this could be retrieved and installed by following the steps below_
1. Go to the url https://github.com/shuklaaradhana/UserResume
Navigate to the `release` tab
1. You will find `User Resume Apk`
1. Go to the `Assets` section, you will find the apk named `resume-app-release.apk`
1. Click on the file name, it will get downloaded in the android device
1. `Open` the dowloaded app, it will ask for your permission to install the app
1. Click on `Install`, it will ask your permission to install from `Unknown sources`
1. Allow installing from `Unknown sources`, the app will get installed.
1. After installation you will see the users list screen with multiple users.
1. Click on any user and you will be navigated to the resume of that user.

## Tools and Technologies used

#### Key points - <br/>
* Used Dagger 2 for injection of Activities, Fragments and other classes <br/>
* Used Retrofit 2 for network calls
* Used RxJava 2
* Used Data Binding to set the text and onClick calls
* Used JUnit and Mockito for Unit testing
* Used espresso for UI instrumented test cases
* Used Kotlin
* Using MVVM design pattern 
* Used dimen and style xml files to standardize the layout throughout the app <br/>
* Used vector drawables
* Used ConstraintLayout
* Used RecylerView to show
    * User names list on the first screen
    * List of the user experiences when clicking on a particular user name on the first screen, user is navigated to his resume 

## About the App 
#### _The app consists of two screens_
1. First screen shows the list of users, uses RecylerView (ResumeListFragment)
1. When you click on the user name on the first screen, resume details of that user are shown along with the list of his experiences. The list of experiences is a recycler view which can be scrolled. (ResumeDetailsFragment)

<img width="236" alt="User_List" src="https://user-images.githubusercontent.com/5384429/66415633-e5c63980-e9b0-11e9-945b-2231bca78dcb.png">
<img width="236" alt="User_resume_details" src="https://user-images.githubusercontent.com/5384429/66415640-e9f25700-e9b0-11e9-90c4-0302721cea9e.png">

## Run the test cases
1. Unit Test cases (ResumeViewVmImplTest class) 
1. UI Instrumented Test Cases (ResumeDetailsTest class)


`
