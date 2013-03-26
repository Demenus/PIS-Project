uniform mat4 camera;
attribute vec4 color;
varying vec4 vColor;
attribute vec4 position;
attribute vec3 normal;
attribute vec2 textureCoords;
varying vec2 vTextureCoords;
varying float intensity;

void main() {
	vTextureCoords = textureCoords;
	vec3 lightDir = vec3(0,1,0);
	intensity = dot(lightDir, normal);

	gl_Position = camera * position;
}