let subjects = document.querySelectorAll('.subject');
let totalBox = document.getElementById('total');
let confirmationBox = document.getElementById('confirmationMessage');

subjects.forEach(item => {
    item.addEventListener('change', () => {
        let total = 0;
        subjects.forEach(sub => {
            if (sub.checked) {
                total += parseInt(sub.value);
            }
        });
        totalBox.textContent = "$" + total;
    });
});

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
        confirmationBox.textContent = "Please select at least one course to register.";
        confirmationBox.style.color = "red";
        alert("Please select at least one course to register.");
        return;
    }

    let studentName = this.querySelector('input[name="studentName"]').value.trim();

    let numberedSubjects = selectedSubjects.map((sub, index) => (index + 1) + ". " + sub).join("\n");

    let message = "Name: " + studentName + ",\n\n";
    message += "You have successfully registered for the following courses:\n";
    message += numberedSubjects + "\n\n";
    message += "Total Registration Fee: " + totalFee;

    confirmationBox.innerHTML = message.replace(/\n/g, "<br>");
    confirmationBox.style.color = "green";

    alert(message);

    this.reset();
    totalBox.textContent = "$0";
});