<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

		<input type="file" id="fileupload">
		<div>
    		<button id="btn">Submit</button>
  		</div>
	
	
	<script>
    function test() {
    	const CLOUDINARY_URL = 'https://api.cloudinary.com/v1_1/dhkowsqaz/image/upload';
    	const CLOUDINARY_UPLOAD_PRESET = 'ml_default';
    	const image = document.querySelector('#fileupload');
    	image.addEventListener('change', (e) => {
    	  const file = e.target.files[0];
    	  const formData = new FormData();
    	  formData.append('file', file);
    	  formData.append('upload_preset', CLOUDINARY_UPLOAD_PRESET);

    	  fetch(CLOUDINARY_URL, {
    	    method: 'POST',
    	    body: formData,
    	  })
    	    .then(response => response.json())
    	    .then((data) => {
    	      if (data.secure_url !== '') {
    	        const uploadedFileUrl = data.secure_url;
    	        localStorage.setItem('passportUrl', uploadedFileUrl);
    	      }
    	    })
    	    .catch(err => console.error(err));
    	});
    }
    let btn = document.getElementById("btn");
    btn.addEventListener('click', event => {
      test();
    });
  </script>
	
	
</body>
</html>