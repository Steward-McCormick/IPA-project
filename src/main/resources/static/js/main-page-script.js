function addToCalcList() {
    const form = document.getElementById("form");
    const div = document.createElement('div');
    div.innerHTML = 
    `
		<select class="form-field" id="consumer" name="consumer" required>
							<option style="display: none;" value="">Потребитель</option>
							<option value="Установки">Установки</option>
							<option value="Автомобильный транспорт">Автомобильный транспорт</option>
						</select>
						<select class="form-field" id="fuelType" name="fuelType" required>
							<option style="display: none;" value="">Топливо</option>
							<option value="Сырая нефть">Сырая нефть</option>
							<option value="Газовый конденсат">Газовый конденсат</option>
							<option value="Бензин автомобильный">Бензин автомобильный</option>
							<option value="Дизельное топливо">Дизельное топливо</option>
							<option value="Керосин осветительный">Керосин осветительный</option>
							<option value="Топливо нефтяное(мазут)">Топливо нефтяное(мазут)</option>
							<option value="Пропан и бутан сж.">Пропан и бутан сж.</option>
							<option value="Углеводородные газы сж.">Углеводородные газы сж.</option>
							<option value="Битум">Битум</option>
							<option value="Коксующийся уголь">Коксующийся уголь</option>
							<option value="Уголь каменный">Уголь каменный</option>
							<option value="Природный газ">Природный газ</option>
							<option value="Дрова для отопления">Дрова для отопления</option>
						</select>
				
						<input type="number" placeholder="Количество" class="form-field" id="amount" name="amount" required>
				
						<select class="form-field" id="unit" name="unit" required>
							<option style="display: none;" value="">Единицы измерения</option>
							<option value="Тонны/год">Тонны/год</option>
							<option value="м3/год">Метры кубические/год</option>
						</select>
				
						<a href="#" onclick="delete_calculation(this)"><img src="/svg/cross.svg" class="form-cross" style="width: 34px; height: 34px"></a>
    `
    if(document.getElementsByClassName('calculation-form-fields').length >= 1) {
        div.style.marginTop = "16px";
    }
    div.className = "calculation-form-fields";

    form.appendChild(div);

    let h = document.querySelector('#html').offsetHeight + 75;
    document.getElementById('html').style.height = h + "px";

    return false;
}

const current_html_height = document.querySelector("#html").offsetHeight;

function delete_calculation(el) {
    el.parentNode.remove();

    let h;

    const sidebar_h = document.getElementById('left-sidebar').offsetHeight;
    if(document.querySelector("#html").offsetHeight - 75 >= sidebar_h) {
        h = document.querySelector("#html").offsetHeight - 75;
    }
    else {
        h = document.querySelector("#html").offsetHeight;
    }
    document.getElementById('html').style.height = h + "px";

    edit_top_form();
}

function edit_top_form() {
    const div = document.getElementsByClassName("calculation-form-fields");
    div[0].style.marginTop = 0;
}