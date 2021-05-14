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
  
  <p><button class="capture-button">Capture video</button>
  <p><button id="screenshot-button">Take screenshot</button></p>
  
<script>
const constraints = {
  video: true,
};

const video = document.querySelector("video");

navigator.mediaDevices.getUserMedia(constraints).then((stream) => {
  video.srcObject = stream;
});

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
</script>


<body>

</body>
</html>