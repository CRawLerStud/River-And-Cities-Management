# River-And-Cities-Management

STORY:
The app is used by a national agency that tracks the average elevation of multiple rivers in a region.

<b>The entities are</b>
<ul>
<li>City</li>
<ul>
<li>Name</li>
<li>River (ID)</li>
<li>Minimum Risk Elevation</li>
<li>Maximum Elevation Allowed</li>
</ul>
<li>River</li>
<ul>
<li>Name</li>
<li>Average Elevation</li>
</ul>
</ul>

<b>The features </b>
<ul>

<li>The cities and the rivers are read from a database, you can not add or delete any of them in the app</li>
<li>The app has two windows</li>
  <ul>
    <li>One to show all the rivers and the average elevation</li>
    <li>One to show all the cities divided in three tables ( Small Risk, Medium Risk, High Risk ) </li>
  </ul>
<li>As an engineer, you cand modify the average elevation for a river</li>
<li>After one modification, the tables will actualise after the new average elevation</li>
  <ul>Explanation: A river travels one or more cities. If a river's average elevation is changed, the risks are recalculated for each city.</ul>
</ul>
