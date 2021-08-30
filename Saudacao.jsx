import React, { Component} from 'react'


export default class saudacao extends Component{

    state = {
        tipo : this.props.tipo,
        nome: this.props.nome
    }
    setTipo(e){
        this.setState({ tipo: e.target.value})
    }
    setNome(e){
        this.setState({ nome: e.target.value})
    }
    render(){
        const {tipo, nome} = this.props
        return(
            <div>
                <h1>{tipo}{nome}</h1>
                <hr/>
                <input type = "text" placeholder = "Tipo.." value = {tipo}/>
                <input type = "text" placeholder = "Nome.." value = {nome}/>
            </div>
        )
    }
}