// Select all checkboxes with class "subject"
let subjects = document.querySelectorAll('.subject');

// Select the span with id "total"
let totalBox = document.getElementById('total');

// Select the confirmation message div
let confirmationBox = document.getElementById('confirmationMessage');

subjects.forEach(item => {
    item.addEventListener('change', () => {
        let total = 0;  // initialize correctly
        subjects.forEach(sub => {
            if (sub.checked) {
                total += parseInt(sub.value);
            }
        });
        totalBox.textContent = "" + total;  // update span text
    });
});

// FIX: Corrected getElementById (no space) and match form id
document.getElementById('regForm').addEventListener('submit', function(event) {
    event.preventDefault();

    let selectedSubjects = [];
    let totalFee = 0;

    subjects.forEach(sub => {
        if (sub.checked) {
            let subjectName = sub.parentElement.textContent.split('(')[0].trim();
            selectedSubjects.push(subjectName);
            totalFee += parseInt(sub.value);
        }
    });

    if (selectedSubjects.length === 0) {
        confirmationBox.textContent = "⚠️ Please select at least one course to register.";
        confirmationBox.style.color = "red";
        return;
    }

    // ✅ Get student name from input field
    let studentName = this.querySelector('input[name="studentName"]').value.trim();

    let message = "Hello " + studentName + ",<br><br>";
    message += "You have successfully registered for the following courses:<br>";
    message += selectedSubjects.join(", ") + "<br><br>";
    message += "Total Registration Fee: $" + totalFee;

    // Display message in the webpage
    confirmationBox.innerHTML = message;
    confirmationBox.style.color = "green";

    this.reset();
    totalBox.textContent = "$0";
});