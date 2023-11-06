import React, { Component } from "react";
import axios from 'axios';

class Fib extends Component {
    state = {
        seenIndexes: [],
        values: [],
        index: ''
    };

    componentDidMount(){
        this.fetchValues();
    }

    async fetchValues(){
        const values = await axios.get('http://192.168.29.17:30006/fibo-app/values');
        this.setState({values: values.data});
    }

    handleSubmit = async (event) => {
        event.preventDefault();

        await axios.post('http://192.168.29.17:30006/fibo-app/calculateFibo',{
            indexValue: this.state.index
        });

        this.setState({index:''});
    }

    renderSeenIndexes(){
        return this.state.values.map(({fibval}) => fibval.index).join(', ');
    }

    renderValues(){
        const entries = [];
        for(let key in this.state.values){
            entries.push(
                <div key={key.index}>
                    For index {key.index} I caculated {key.value}
                </div>
            );
        }
        return entries;
    }
    render(){
        return(
            <div>
                <form onSubmit={this.handleSubmit}>
                    <label>Enter your index:</label>
                    <input value={this.state.index}
                    onChange={event => this.setState({index: event.target.value})}/>
                    <button>Submit</button>
                </form>
                <h3>Indexes I have seen:</h3>
                {this.renderSeenIndexes()}

                <h3>Calculated Values:</h3>
                {this.renderValues()}
            </div>
        );
    }
}

export default Fib;