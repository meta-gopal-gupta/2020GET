if (localStorage.getItem("name") == null) {
    location.replace("employee.html");
}
var questions = [
    { question: " what's your vehicle name?", pattern: /.{2,}/, value: 'User' },
    { question: " enter vehicle type", next: true },
    { question: " enter vehicle number", pattern: /.{6,}/ },
    { question: " enter employee id", pattern: /.{2,}/ },
    { question: " enter vehicle discription", pattern: /.{6,}/ },
];

(function() {

    var position = -1

    putQuestion()

    progressButton.addEventListener('click', validate)
    inputField.addEventListener('keyup', function(e) {
        if (e.keyCode == 13) {
            validate()
        }
    })

    function putQuestion() {
        register.className = '';
        ++position;
        inputLabel.innerHTML = localStorage.getItem("name") + questions[position].question
        inputField.value = ''
        inputField.type = questions[position].type || 'text';
        if (questions[position].next == true) {
            document.getElementById('inputField').style.display = 'none';
            document.getElementById('gender').style.display = 'block';

        } else {
            document.getElementById('inputField').style.display = 'block';
            document.getElementById('gender').style.display = 'none';
        }
    }

    function validate() {
        questions[position].value = inputField.value
        if (position + 1 == questions.length) {
            location.replace("pass.html")
        }
        if (questions[position].next == true) {
            questions[position].value = vehicleType.value
            localStorage.setItem("vehicle", questions[position].value);
        }

        if (!questions[position].value.match(questions[position].pattern || /.+/)) wrong()
        else {
            putQuestion()
        }

    }

    function wrong(callback) {
        register.className = 'wrong'
    }

}())