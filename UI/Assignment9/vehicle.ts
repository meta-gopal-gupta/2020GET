if (localStorage.getItem("name") == null) {
    location.replace("employee.html");
}
var questions = [
    { question: " what's your vehicle name?", pattern: /.{2,}/, type: "text", value: 'User' },
    { question: " enter vehicle type", next: true },
    { question: " enter vehicle number", pattern: /.{6,}/ },
    { question: " enter employee id", pattern: /.{2,}/ },
    { question: " enter vehicle discription", pattern: /.{6,}/ },
];

(function() {

    var position = -1

    putQuestion();

    (<HTMLInputElement>document.getElementById("progressButton")).addEventListener('click', validate);
    (<HTMLInputElement>document.getElementById("inputField")).addEventListener('keyup', function(e) {
        if (e.keyCode == 13) {
            validate()
        }
    })

    function putQuestion() {
        (<HTMLInputElement>document.getElementById("register")).className = '';
        ++position;
        (<HTMLInputElement>document.getElementById("inputLabel")).innerHTML = localStorage.getItem("name") + questions[position].question;
        (<HTMLInputElement>document.getElementById("inputField")).value = '';
        (<HTMLInputElement>document.getElementById("inputField")).type = questions[position].type || 'text';
        if (questions[position].next == true) {
            document.getElementById('inputField').style.display = 'none';
            document.getElementById('gender').style.display = 'block';

        } else {
            document.getElementById('inputField').style.display = 'block';
            document.getElementById('gender').style.display = 'none';
        }
    }

    function validate() {
        questions[position].value = (<HTMLInputElement>document.getElementById("inputField")).value
        if (position + 1 == questions.length) {
            location.replace("pass.html")
        }
        if (questions[position].next == true) {
            questions[position].value = (<HTMLInputElement>document.getElementById("vehicleType")).value;
            localStorage.setItem("vehicle", questions[position].value);
        }

        if (!questions[position].value.match(questions[position].pattern || /.+/)) wrong()
        else {
            putQuestion()
        }

    }

    function wrong() {
        (<HTMLInputElement>document.getElementById("register")).className = 'wrong';
    }

}())