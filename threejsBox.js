			var PI = Math.PI;
			var angle = PI/4;
			var cos = Math.cos;
			var sin = Math.sin;
// renderer			
			var renderer = new THREE.WebGLRenderer();
			renderer.setSize(800, 600);
			document.body.appendChild(renderer.domElement);

			var scene = new THREE.Scene();
// camera
			var camera = new THREE.PerspectiveCamera(35, 800 / 600, 0.1, 10000);
			camera.position.set(-30, 10, 0);
			camera.lookAt(scene.position);

			var geometry = new THREE.BoxGeometry(4, 4, 4);
			var material = new THREE.MeshLambertMaterial({
				color : 0xFF0000
			});
			var box = new THREE.Mesh(geometry, material);
			scene.add(box);

// guideLine
			var glMaterial = new THREE.LineBasicMaterial({ color : 0x000000 });
			var glGeometry = new THREE.Geometry();
			glGeometry.vertices.push(
				new THREE.Vector3(0, 0, -100),
				new THREE.Vector3(0, 0, 100)
			);
			var guideLine = new THREE.Line( glGeometry, glMaterial);
			scene.add( guideLine );
// light
			var light = new THREE.PointLight(0xFFFF00);
			light.position.set(10, 0, 10);
			scene.add(light);
// light2
			var light2 = new THREE.PointLight(0xFFFF00);
			light2.position.set(-10, 9, 10);
			scene.add(light2);
// background
			renderer.setClearColor(0xdddddd, 1);
// box-default-position
			box.position.x=2;

			loop();
		
			function loop() {
				if(angle >= PI*3/4){
					moveBox();	
				}else{
					rotationBox();
				}
				
				renderer.render(scene, camera);
				requestAnimationFrame(loop);
			}

			function rotationBox() {
				angle += 0.05
				if(angle >= PI*3/4) angle = PI*3/4;
			
				box.position.z = cos(angle) * 2.8 ;
				box.position.y = sin(angle) * 2.8 ;
				box.rotation.x = -(angle - PI/4);
				
			}
			function moveBox(){
				box.position.z += 0.05;
				if(box.position.z > 2){
					angle = PI/4;
				}
			}