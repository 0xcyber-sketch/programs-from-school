
    // opgve 5.1
    
    let numberLabel = document.createElement('label');
    let timeLabel = document.createElement('label');

    //numberLabel.setAttribute('for', 'tal')
    numberLabel.innerHTML = 'Tal:'
    numberLabel.appendChild(document.getElementById('tal'))

    timeLabel.innerHTML = 'Tid:'
    timeLabel.appendChild(document.getElementById('tid'))
    
    
    document.body.appendChild(numberLabel)
    document.body.appendChild(timeLabel)

    document.getElementById('tal').addEventListener('click', (event) => {
        let number = 0;
        let input = document.getElementById('tal')
        number = Math.ceil(Math.random() * 1000)
        input.value = number
        //window.alert(number)
    })

    document.getElementById('tid').addEventListener('click', (event) => {
        // undersg this
        let input = e.this //document.getElementById('tid')
        let time = new Date()
        number = Math.ceil(Math.random() * 10)
        input.value = "" + (time.getHours() + number ) + " : " + (time.getMinutes() + number)
        //window.alert(number)
    })



   


