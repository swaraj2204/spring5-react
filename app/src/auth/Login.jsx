import * as React from 'react'
import {Card, CardContent, Button, CardHeader} from '@material-ui/core';
import Avatar from "@material-ui/core/Avatar";
import IconButton from "@material-ui/core/IconButton";
import TextField from "@material-ui/core/TextField";
import InputAdornment from "@material-ui/core/InputAdornment";
import {AccountCircle, SupervisorAccount, Visibility, VisibilityOff} from "@material-ui/icons";
import Grid from "@material-ui/core/Grid";

class Login extends React.Component {


    constructor(props) {
        super(props);
        this.state = {
            showPassword: false,
            password: '',
            userName: '',
            error:"",
            tenant:""
        }

    }

    componentDidMount() {

    }

    handleChange(type,e) {
        let data=this.state;
        if(type==="userName")
            data.userName=e.target.value;
        else if(type==="password")
            data.password=e.target.value;
        else if(type==="tenant")
            data.tenant=e.target.value;
        this.setState({data})
    }

    handleMouseDownPassword(e) {
        e.preventDefault();
    }
    submitForm(){
        let data=this.state;
        let that=this;
        fetch('http://localhost:8259/compute', {
            method: 'POST',
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json',
            },
            body: JSON.stringify({
                user: data.userName,
                password: data.password,
                tenant:data.tenant
            })
        }).then(res=>res.json()).then((result)=>{
            this.props.handleLogin(true);
        },(error)=>{that.setState({error:error.messageData})})

    }

    handleClickShowPassword() {
        this.setState({showPassword: !this.state.showPassword});
    }


    render() {
        let data = this.state;
        return (
            <Card style={{height:"400px"}}>
                <CardHeader
                    avatar={
                        <Avatar aria-label="recipe">
                            L
                        </Avatar>
                    }
                    title="Login"
                    subheader={(data.error)?(<span style={{color:"red"}}>{data.error}</span>):(null)}
                />
                <CardContent>
                    <Grid
                        container
                        direction="column"
                        justify="flex-start"
                        alignItems="center"
                        spacing={3}
                    >
                        <Grid item>
                            <TextField
                                id="tenant"
                                variant="outlined"
                                label="Tenant"
                                value={this.state.tenant}
                                onChange={this.handleChange.bind(this,'tenant')}
                                InputProps={{
                                    endAdornment: <InputAdornment position="end"><SupervisorAccount/></InputAdornment>,
                                }}
                            />
                        </Grid>
                        <Grid item>
                            <TextField
                                id="user"
                                variant="outlined"
                                label="UserName"
                                value={this.state.userName}
                                onChange={this.handleChange.bind(this,'userName')}
                                InputProps={{
                                    endAdornment: <InputAdornment position="end"><AccountCircle/></InputAdornment>,
                                }}
                            />
                        </Grid>
                        <Grid item>
                            <TextField
                                id="outlined-adornment-password"
                                variant="outlined"
                                type={data.showPassword ? 'text' : 'password'}
                                label="Password"
                                value={data.password}
                                onChange={this.handleChange.bind(this,'password')}
                                InputProps={{
                                    endAdornment: (
                                        <InputAdornment position="end">
                                            <IconButton
                                                edge="end"
                                                aria-label="toggle password visibility"
                                                onClick={this.handleClickShowPassword.bind(this)}
                                                onMouseDown={this.handleMouseDownPassword.bind(this)}
                                            >
                                                {this.state.showPassword ? <VisibilityOff/> : <Visibility/>}
                                            </IconButton>
                                        </InputAdornment>
                                    ),
                                }}
                            />
                        </Grid>
                        <Grid item>
                            <Button variant="contained" color="primary" onClick={this.submitForm.bind(this)} >
                                Login
                            </Button>
                        </Grid>
                    </Grid>
                </CardContent>
            </Card>

        )
    }

}

export default (Login);