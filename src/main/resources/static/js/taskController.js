class taskController{
    constructor(){
        this.domainUrl = "http://localhost:8080/";
        this.addItemApi = this.domainUrl + "task/add";
        this.allItemApi = this.domainUrl + "task/all";
        this.taskList = [];
    }

    getAllTask(){
        let taskController = this;
        taskController.taskList = [];
        fetch(this.allItemApi)
                        .then((resp) => resp.json())
                        .then(function(data) {
                            console.log("2. receive data")
                            data.forEach(function (task, index) {

                                const taskObj = {
                                    id: task.id,
                                    title: task.title,
                                    description: task.description,
                                    date: task.date
                               };
                                taskController.taskList.push(taskObj);
                          });

                          taskController.display();

                        })
                        .catch(function(error) {
                            console.log(error);
                        });

    }

    display(){

        let str = "<tr><th>Title</th><th>Description</th><th>Target Date</th></tr>";

        if (this.taskList.length !=0){
        
            this.taskList.forEach(task => {
                str += `<tr><td>${task.title}</td>
                <td>${task.description}</td><td>${task.date}</td>
                </tr>`
            });
    
        }
        else{
            str+="<tr>No task found!</tr>"
        }
    document.querySelector("#itemList").innerHTML = str;
    }

    addTask(title, description, date){
        let taskController = this;
        const formData = new FormData();
        formData.append('title', title);
        formData.append('description', description);
        formData.append('date', date);

        fetch(this.addItemApi, {
            method: 'POST',
            body: formData
            })
            .then(function(response) {
                console.log(response.status);
                if (response.ok) {
                    alert("Successfully Added TODO!")
                }
            })
            .catch((error) => {
                console.error('Error:', error);
                alert("Error adding task to TODO")
            });

    }
}

function addNewTask(){

    let formTitle = document.querySelector("#title").value;
    let formDesc = document.querySelector("#description").value;
    let formDate = document.querySelector("#date").value;
    tasks.addTask(formTitle, formDesc, formDate);
}

const tasks = new taskController();


