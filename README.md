# Switch Button for SWT

Originally taken from Opal project (https://code.google.com/a/eclipselabs.org/p/opal/). This is a simplified version of the original widget.
* No more label on the right (the user is free to create a label using `Label` or `CLabel`)
* Fixes some issue with the drawing in my GTK Linux;
* Introduce keyboard listener (key selection and key traversal);
* Draw the focus line when widget get focus;
* Uses JFace resource for label (Yes, No). So translation is supported out of the box;
* Adapt it's size according to the layout.

# Preview
## Windows XP
![alt tag](preview_winxp.png)

## Windows 7
![alt tag](preview_win7.png)

## Gnome 3
![alt tag](preview_gnome3.png)

# Usage
For maven project, you need to update you `pom.xml`.
```
[...]
<repositories>
    <repository>
        <id>patrikdufresne</id>
        <url>http://nexus.patrikdufresne.com/content/groups/public/</url>
    </repository>
</repositories>
[...]
<dependencies>
    <dependency>
        <groupId>com.patrikdufresne</groupId>
        <artifactId>com.patrikdufresne.switchbutton</artifactId>
        <version>1.0</version>
    </dependency>
</dependencies>
[...]
```



