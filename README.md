# Events App

The app is structered in a hierarchical manner. The main activity displays a list of event categories in a grid, with each event category represented by an image. By clicking on an event category, a new activity is started which lists the events under that category. Clicking on an event then displays the details of the event in a new activity. Clicking the phone icon next to the Coordinator's name and number will automatically place a call to them, and will request permission to do so if it is not already granted.

I have assumed that the event details will be received as a JSON object with particular parameters. I have also created a sample JSON file with some event categories and events to demo the app. (The phone numbers were randomly typed, so it is better to not let the call to those numbers go through).
