#!/bin/bash

# Constants
DIRECTORY=${PWD##*/}
TITLE="Here are the files located in this directory: $DIRECTORY"
RIGHT_NOW="$(date +"%x %r %Z")"
TIME_STAMP="Updated on $RIGHT_NOW by $USER"
FILENAME="index.html"


# Function to list the contents of the current directory
list_directory(){
	printf '%s\n' *
}


# Create the HTML file

# EOF = here document which is a section of code that is treated like a separate file
cat > $FILENAME <<_EOF_
	<!DOCTYPE html>
	<html>

	<head>

	<title>List Directory Script</title>

	<style>
	{
		box-sizing: border-box;
	}
	.sansserif {
  		font-family: Arial, Helvetica, sans-serif;
  	}
	body {
		background-color: #FFF;

	}
	h1 {
		color: #1F1B24;
		margin-left: 
		font-size: 40px;
	}

	div {
		padding-left: 25px;
		padding-right: 0px;
	}

	pre {
		color: #1F1B24;
		font-size: 25px;
	}

	footer {
		color: #1F1B24;
		margin-left;
		font-size: 12px;
	}

	</style>
	</head>
	<body>
		<h1 class="sansserif">$TITLE</h1>
		<div>
		<pre>$(list_directory)</pre>
		</div>
		<footer class="sansserif">$TIME_STAMP</footer>
	</body>
	</html>
_EOF_

# Open index.html file
firefox $FILENAME