precision mediump float;
varying float intensity;
varying vec2 vTextureCoords;
uniform sampler2D texture; 


void main() {

	gl_FragColor = texture2D(texture, vTextureCoords);
}