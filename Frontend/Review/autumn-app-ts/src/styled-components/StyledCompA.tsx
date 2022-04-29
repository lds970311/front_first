import React, {Component} from 'react';
import styled from "styled-components";

class StyledCompA extends Component {
    render() {
        const StyledFooter = styled.footer`
          background: yellow;
          position: fixed;
          left: 0;
          bottom: 0;
          width: 100%;
          height: 50px;
          line-height: 50px;
          text-align: center;

          ul {
            display: flex;
            list-style: none;


            li {
              flex: 1;
              line-height: 50px;

              &:hover {
                background: red;
              }
            }
          }
        `;

        return (
            <StyledFooter>
                <ul>
                    <li>首页</li>
                    <li>列表</li>
                    <li>我的</li>
                </ul>
            </StyledFooter>
        );
    }
}

export default StyledCompA;
