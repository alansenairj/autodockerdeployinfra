from flask import render_template, Flask, jsonify, request

#ativar a aplicaçao
app = Flask(__name__)

#carregar a pagina inicial
@app.route("/")
def home():
    
    return render_template('index.html')

#responder metodo POST
@app.route("/name", methods=["POST"])
def setName():
    if request.method=='POST':
        posted_data = request.get_json()
        data = posted_data['data']
        return jsonify(str("Successfully stored  " + str(data)))

#responder metodo get
@app.route("/message", methods=["GET"])
def message():
    posted_data = request.get_json()
    name = posted_data['name']
    return jsonify(" Hope you are having a good time " +  name + "!!!")

#thread para iniciar servidor aberto com porta exposta
if __name__=='__main__':
    app.run(host="0.0.0.0", port=8085, debug=True)
