var flag=0;
function changeTu(){
	$(".change").hide();
	$(".listen-stop").show();
	$(".listen-wenzi").show();
	startRecording();
}
var recorder;

var audio = document.querySelector('audio');

function startRecording() {
    HZRecorder.get(function (rec) {
        recorder = rec;
        recorder.start();
        
       // setTimeout("stopRecording()",10000); 
      //  setTimeout("uploadAudio()",10000);
    });
    
    
}


function stopRecording() {
    recorder.stop();
    uploadAudio();
}

function playRecording() {
    recorder.play(audio);
}

function uploadAudio() {
    recorder.upload("upload", function (state, e) {
        switch (state) {
            case 'uploading':
                //var percentComplete = Math.round(e.loaded * 100 / e.total) + '%';
                break;
            case 'ok':
                //alert(e.target.responseText);
                //alert("�ϴ��ɹ�");
                top.location.href="listen";
                break;
            case 'error':
                alert("�ϴ�ʧ��");
                break;
            case 'cancel':
                alert("�ϴ���ȡ��");
                break;
        }
    });
}
