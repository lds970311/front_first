import React, {Component} from 'react';
import {ApolloClient} from "apollo-boost";
import {ApolloProvider, Query, Mutation} from "react-apollo";
import gql from "graphql-tag";

const client = new ApolloClient({
    uri: "http://localhost:12889/graphql",
});

class GraphqlView extends Component {
    render() {
        return (
            <ApolloProvider client={client}>
                <MyQuery/>
            </ApolloProvider>
        );
    }
}


class MyQuery extends Component {
    query = gql`
        query getNowPlayingList($id:String!){
            getNowPlayingList(id:$id) {
                id,
                name,
                price
            }
        }
    `
    state = {
        id: "61e66f60dd8ae3c99074ac53"
    }

    createFilm = gql`
        mutation updateFilm($id:String!,$input: FilmInput){
            updateFilm(id:$id,input:$input) {
                id,
                name,
                price
            }
        }
    `

    render() {
        return (
            <div>
                <input type="text" onChange={(evt) => {
                    this.setState({
                        id: evt.target.value
                    })
                }}/>
                <Query query={this.query} variables={{id: this.state.id}}>
                    {
                        ({loading, data, refetch}) => {
                            console.log(loading)
                            return loading ? <div>loading....</div> :
                                <div>
                                    {
                                        data.getNowplayingList.map(item =>
                                            <div key={item.id}>
                                                <div>名字：{item.name}</div>
                                                <div>价格：{item.price}</div>
                                            </div>
                                        )
                                    }
                                </div>
                        }
                    }
                </Query>
                <Mutation mutation={this.createFilm}>
                    {
                        (updateFilm, {data}) => {
                            console.log(data)
                            return <div>
                                <button onClick={() => {
                                    updateFilm({
                                        variables: {
                                            id: "61e67c0031bf52b53c9245c7",
                                            input: {
                                                name: "777-修改",
                                                poster: "http://777-修改",
                                                price: 700
                                            }
                                        }
                                    })
                                }}>update
                                </button>
                            </div>
                        }
                    }
                </Mutation>
            </div>

        );
    }
}


export default GraphqlView;
