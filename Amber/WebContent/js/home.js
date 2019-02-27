
//function uploadText() {
//	var fileInput = document.getElementById('fileInput');
//	var fileDisplayArea = document.getElementById('write-text');
//
//	fileInput.addEventListener('change', function(e) {
//		var file = fileInput.files[0];
//		var textType = /text.*/;
//
//		if (file.type.match(textType)) {
//			var reader = new FileReader();
//
//			reader.onload = function(e) {
//				fileDisplayArea.innerText = reader.result;
//			}
//
//			reader.readAsText(file);	
//		} else {
//			fileDisplayArea.innerText = "File not supported!"
//		}
//	});
//}

function textSave(){
	var text = document.getElementById('read-text').innerHTML;
	alert("进入了");
	console.log(text);
	alert(text);
}

function showLen(){
	var len = document.getElementById('write-text').innerHTML;
	document.getElementById('show-result').innerHTML = len.length;
}
document.getElementById('write-text').onkeyup = function() {
    // 获取选定对象
    var selection = getSelection()
    // 设置最后光标对象
    lastEditRange = selection.getRangeAt(0)
}