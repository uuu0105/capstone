<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>카메라이용</title>

  <video autoplay></video>
  <img src="">
  <canvas style="display:none;"></canvas>
  
  <p><button id="capture-button">Capture video</button></p>
  <p><button id="screenshot-button">Take screenshot</button></p>
  
<script>
const constraints = {
	video: true,
};

const video = document.querySelector("video");
const img = document.querySelector("img");

navigator.mediaDevices.getUserMedia(constraints).then((stream) => {
  video.srcObject = stream;
});

const captureVideoButton = document.querySelector("#capture-button");
const screenshotButton = document.querySelector("#screenshot-button");

const canvas = document.createElement("canvas");

captureVideoButton.onclick = function () {
	  navigator.mediaDevices
	    .getUserMedia(constraints)
	    .then(handleSuccess)
	    .catch(handleError);
};

screenshotButton.onclick = video.onclick = function () {
  canvas.width = video.videoWidth;
  canvas.height = video.videoHeight;
  canvas.getContext("2d").drawImage(video, 0, 0);
  
  // Other browsers will fall back to image/png
  img.src = canvas.toDataURL("image/webp");
};

function handleSuccess(stream) {
	  screenshotButton.disabled = false;
	  video.srcObject = stream;
}
</script>


<body>

</body>
</html>