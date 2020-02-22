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

Device used for testing: Nexus 5 API 29

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

## Journal 5: End of a day progress and what to do next
Completed
- sign in page
- login page
- demo version of home page
- local database

What to do
- Create homepage
    - consider menu
- use id as key (check duplicate)
- create table for each id (user)
- finalize database/data flow


## Journal 6: setting interface design (time to take a break)
Since sign in and login pages are almost set, I arrange buttons and text boxes on pages to fit into my test device, Nexus 5. Also I change color and font size! It looks good by now. All the functions implemented before still works well.
Then, I move on to create an interface of home page. On the home page, user id will be displayed for now. There will be buttons that move to different pages. Also, there should be log out button!!
After creating the home page, it is time to delete login_sub page, which was used for testing purpose.

The user ID successfully displayed on the home page. I push the project before I remove login_sub layout to make sure nothing goes wrong from this :)

## Journal 7: Create Edit user information page
By now, three of requirements are met.
1. Create an account
2. Log in with a valid username and password
3. Logout and allow other users to log in

Last requirement is: 4. Update profile information (username, password, and all the information displayed on the various tabs/button/delineations within the system).
For now, user information includes ID and password. I need to add username as user information. Let's consider "About me" page. Following features will be implemented to get user info.
Edit profile page:
- username
- short sentences about myself

Edit profile page is added. User can put username, short sentences about myself, and password to edit. The blank input is not allowed. I have not test if it successfully update user profile.
Next: I will create user profile page to test user profile is successfully updated.

## Journal 8: User Profile page
Finally!! I can view profile. Even after I log out and log in again, I can see stored profile. I really struggled to make it works. I can't remember what changes I made, but I made a lot of change to make it.
Connecting and using database on Java is not simple as I thought. It took 5 hours to figure it out, but it was really valuable time. My application is simple, but I satisfy with it, since I can use real database on application now!


## LAST Journal 9: Update profile function
I success to update the profile, but it has viewing problem after updating profile. I spent too much time on annoying error, misreading sql statement String variable. Declaring string variable causes such a huge problem.
I think it is easy to be fixed. Since I spent unexpectedly long time to fix database problem, I do not have time to fix it.
But I will fix it even after this project ends. I think I know the solution, using getter method instead of indent.putExtra(variable). Since I initially pass around the data between the activities/pages, I need to fix some code to change it to get data with sql query.
Overall, it was really valuable experience, since I did not have an experience of developing mobile application. It helps me to be more engaged in our team project as project manager and also backend :)










