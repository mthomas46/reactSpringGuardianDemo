//'use strict';

const React = require('react');
const ReactDOM = require('react-dom');
const client = require('./client');
import {Button, Table} from 'react-bootstrap'


class App extends React.Component {

	constructor(props) {
		super(props);
		this.state = {guardians: [], foundGuardians:[]};
	}

	componentDidMount() {
		client({method: 'GET', path: '/api/guardians'}).done(response => {
			this.setState({guardians: response.entity._embedded.guardians});
		});
		client({method:'GET', path:"/import-Guardian?displayName=afroKing42"}).done(response => {
            console.log(response.entity.Response);
            this.setState({foundGuardians: response.entity.Response});
        });
	}

	render() {
		return (
		    <>
			    <GuardianList guardians={this.state.guardians}/>
			    <Button variant="primary">Primary2</Button>{' '}
			    <FoundGuardians foundGuardians={this.state.foundGuardians}/>
			</>
		)
	}
}

class FoundGuardians extends React.Component{


    render(){
    const foundList = this.props.foundGuardians.map(fg =>(<tr><td>{fg.displayName}</td> <td>{fg.membershipId}</td></tr>));
    return(
    <>
        <div>RESULTS Via Destiny  API</div>
        <Table striped bordered hover variant="dark">
            <tbody>
                <tr>
                    <th>displayName</th>
                    <th>membershipId</th>
                </tr>
                {foundList}
            </tbody>
        </Table>
    </>
    )
    }
}

class GuardianList extends React.Component{
	render() {
		const guardians = this.props.guardians.map(guardian =>
			<Guardian key={guardian._links.self.href} guardian={guardian}/>
		);
		return (
		<>
		<div>CURRENTLY IN DATABASE</div>
			<Table striped bordered hover variant="dark">
				<tbody>
					<tr>
						<th>displayName</th>
						<th>membershipId</th>
					</tr>
					{guardians}
				</tbody>
			</Table>
			</>
		)
	}
}

class Guardian extends React.Component{
	render() {
		return (
			<tr>
				<td>{this.props.guardian.displayName}</td>
				<td>{this.props.guardian.membershipId}</td>
			</tr>
		)
	}
}

ReactDOM.render(
	<App />,
	document.getElementById('react')
)