import React, {Component} from 'react';
import './Botoes.css'

class BotoesTeste extends Component{
    render(){
        return(
            <button onClick={()=>{this.props.handleclick(this.props.label);}}>
                {this.props.label}
            </button>

        );
    }
}

class Mylabel extends Component{
    render(){
        return <span>Clique no: {this.props.text}</span>
    }
}

class Botoes extends Component{
    construtor(props){
        super(props)

        this.setState = {
            labelText: '',
        }
    }
    setLabelText = (labelText) =>{
        this.setState({labelText});
    }

    render(){
        return(
            <div className = "Botões">
                <Mylabel text = {this.state.labelText}/>
                <br/>
                <BotoesTeste handleclick = {this.setLabelText} label = "Bom dia"/>
                <BotoesTeste handleclick = {this.setLabelText} label = "Bom tarde"/>
                <BotoesTeste handleclick = {this.setLabelText} label = "Bom noite"/>
            </div>
        )
    }
}
export default Botoes;

