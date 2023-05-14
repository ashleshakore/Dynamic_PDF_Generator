// Assume that 'data' is an object containing the bill data

// Retrieve the HTML template
var template = document.getElementById("bill-template").innerHTML;

// Compile the template using Handlebars
var compiledTemplate = Handlebars.compile(template);

// Bind the data to the template
var html = compiledTemplate(data);

// Insert the HTML into the DOM
document.getElementById("bill-container").innerHTML = html;
