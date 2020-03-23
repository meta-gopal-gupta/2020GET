if (localStorage.getItem("name") != null) {
    localStorage.removeItem("name");
    localStorage.removeItem("vehicle");
}

var questions = [
    { question: " what's your full name?", pattern: /.{2,}/, value: 'User' },
    { question: " select your gender", pattern: /.{2,}/, type: "radio", next: true },
    { question: " enter your email?", pattern: /^[^\s@]+@[^\s@]+\.[^\s@]+$/ },
    { question: " enter your password", pattern: /.{6,}/, type: "password" },
    { question: " re enter your password", pattern: /.{6,}/, type: "password" },
    { question: " enter your contact number", pattern: /.{6,}/ }
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
        inputLabel.innerHTML = questions[0].value + questions[position].question
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
            localStorage.setItem("name", questions[0].value);
            location.replace("vehicle.html")
        }
        if (questions[position].next == true) {
            questions[position].value = "male"
            localStorage.setItem("vehicle", questions[position].value);
        }

        if (!questions[position].value.match(questions[position].pattern)) wrong()
        else {
            putQuestion()
        }

    }

    function wrong(callback) {
        register.className = 'wrong'
    }

}())