class MessageBox extends React.Component{
    onClick = ()=>{
        alert('clicked');
    }
    render = ()=>{
        return ( <div><h1 onClick={this.onClick}>Hello World!</h1></div> )
    }
}
ReactDOM.render( <MessageBox/>,
    document.getElementById('like_button_container'),
)
