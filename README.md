# SpikeExercise
 Spike Exercise for Software Engineering


ToDo
1. Create an account
2. Log in with a valid username and password
3. Logout and allow other users to log in
4. Update profile information (username, password, and all the information displayed on the various tabs/button/delineations within the system)


5. (Extra) Share your profile with other users in the system; create friend lists; allow friends to suggest edits to the "All about me" system content
6. (Extra) Upload and store pictures in the system database

Language used: Java, SQL
Program used: Android Studio, SQLite

## Journal 1
Since it is my first time developing android application, I started with installing Android Studio and learned how to run it on the android virtual device. I created a basic features such as changing text and creating a button on the interface.
On Android developer website, I learned what each file in the project file does. All the features I created or changed are reflected on the android virtual device, Pixel 2 API 29.
I moved on to connect the project with git repository as public. It is all set to start coding now.

Source: https://developer.android.com/training/basics/firstapp/creating-project

## Journal 2: Login page
I create the login interface with features like entering id and password and login button. It takes time to figure out a way to switch pages by clicking a button. I creates a new activity in Layout folder which automatically creates a new layout/page for me!
I create a button on a new page and linked it to login page by writing a function 'onclick'.
When I enter id and password and click Login button, it passes and displays id and password on a new page.

## Journal 3: Connect to database
I write codes that create local database and a user table in it. In order to test it, I need to create an interface for sign in page. User can create id and password and these will be stored in user table in the database.
It does not work for now, but I will implement functions that get user input and store in database.

More idea for future: limit character type for keyboard input & use Firebase for database

Source: https://developer.android.com/training/data-storage
Source: https://developer.android.com/training/data-storage/sqlite


## Journal 4: Create sign in page
Now, overall structures of login page and sign in page are set. It successfully store user id and password when a user creates an account. Once id and password are stored, a user can sign in and view id and password on a login sub-page.
User id and password are correctly displayed on the screen. Now, I will use this displaying function to change login sub-page into the main page.
I struggled to connect all database helper, signin, login sub and login pages together, but by now, I understand how database is used and functions are working by now.

More idea for future: which one is better? using local database that is created within the application by coding OR using a database created from SQLite (can view all the available data on SQLite and use same database file on every device)
- I will set overall structures for now, and think about it later..

